package io.dropwizard.bundles.jsonlog;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.Appender;
import io.dropwizard.logging.LoggingUtil;
import io.dropwizard.logging.async.AsyncLoggingEventAppenderFactory;
import io.dropwizard.logging.filter.ThresholdLevelFilterFactory;
import io.dropwizard.logging.layout.DropwizardLayoutFactory;
import java.util.concurrent.TimeUnit;
import org.junit.Test;

import static org.awaitility.Awaitility.await;
import static org.junit.Assert.assertNotNull;

/**
 *
 */
public class JsonConsoleAppenderFactoryTest {

  @Test
  public void build() throws Exception {
    await().atMost(5, TimeUnit.SECONDS).until(() -> System.out != null);

    final JsonConsoleAppenderFactory factory = new JsonConsoleAppenderFactory();

    final Appender<ILoggingEvent> appender = factory.build(LoggingUtil.getLoggerContext(), "app",
        new DropwizardLayoutFactory(), new ThresholdLevelFilterFactory(),
        new AsyncLoggingEventAppenderFactory());
    assertNotNull(appender);
  }

}