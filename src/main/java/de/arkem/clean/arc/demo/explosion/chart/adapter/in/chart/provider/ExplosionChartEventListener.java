package de.arkem.clean.arc.demo.explosion.chart.adapter.in.chart.provider;

import com.azure.messaging.servicebus.*;
import de.arkem.clean.arc.demo.explosion.chart.usecase.in.ImportExplosionChart;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class ExplosionChartEventListener {
    private static final String CONNECTION_STRING = "explosion-chart-event-listener";
    private static final String QUEUE_NAME = "explosion-chart";
    private ServiceBusProcessorClient processorClient;
    private final ImportExplosionChart importExplosionChart;
    private final ExplosionChartEventMapper mapper;

    public ExplosionChartEventListener(ImportExplosionChart importExplosionChart, ExplosionChartEventMapper mapper) {
        this.importExplosionChart = importExplosionChart;
        this.mapper = mapper;
    }

    @PostConstruct
    public void startProcessorClient() {
        ServiceBusClientBuilder clientBuilder = buildClientWithConnetionString(CONNECTION_STRING);
        processorClient = buildProcessorClient(QUEUE_NAME, clientBuilder);
        processorClient.start();
    }

    @PreDestroy
    public void closeProcessorClient() {
        if (processorClient != null) {
            processorClient.close();
        }
    }

    //example for single level of abstraction
    private void processMessage(ServiceBusReceivedMessageContext context) {
        ServiceBusReceivedMessage message = extractMessage(context);
        executeExplosionChartImport(message);
        completeContext(context);
    }

    private void completeContext(ServiceBusReceivedMessageContext context) {
        // Complete the message to remove it from the queue
        context.complete();
    }

    private ServiceBusReceivedMessage extractMessage(ServiceBusReceivedMessageContext context) {
        return context.getMessage();
    }

    private void executeExplosionChartImport(ServiceBusReceivedMessage message) {
        var explosionChartCreatedEvent = message.getBody().toObject(ExplosionChartCreatedEvent.class);
        importExplosionChart.importt(mapper.mapToDomain(explosionChartCreatedEvent));
    }

    private void processError(ServiceBusErrorContext context) {
        System.err.println("Error occurred: " + context.getException().getMessage());
        if (context.getErrorSource() != null) {
            System.err.println("Error source: " + context.getErrorSource());
        }
    }

    private ServiceBusProcessorClient buildProcessorClient(String queueName, ServiceBusClientBuilder clientBuilder) {
        // Create a processor for the queue
        return clientBuilder.processor()
                .queueName(queueName)
                .processMessage(this::processMessage)
                .processError(this::processError)
                .buildProcessorClient();
    }

    private ServiceBusClientBuilder buildClientWithConnetionString(String connectionString) {
        // Create a Service Bus client
        return new ServiceBusClientBuilder().connectionString(connectionString);
    }
}
