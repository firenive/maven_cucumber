package hooks;

import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import nicebank.TransactionProcessor;
@ScenarioScoped
public class BackgroundProcessHooks {
    private Thread transactionProcessorThread;

    @Before
    public void startBackgroundThread(){
        transactionProcessorThread = new Thread() {
            public void run() {
                TransactionProcessor processor = new TransactionProcessor();
                processor.process();
            }
        };
        transactionProcessorThread.start();
    }
    @After
    public void stopBackgroundThread() {
        transactionProcessorThread.interrupt();
    }
}
