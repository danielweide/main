# danielweide
###### \java\seedu\address\logic\commands\AddCommand.java
``` java
    public static final String COMMAND_ALIAS = "a";
```
###### \java\seedu\address\logic\commands\LoggingCommand.java
``` java
public class LoggingCommand {
    private final Logger logger = LogsCenter.getLogger(LoggingCommand.class);
    /**
     *keepLog Method to Write Activity Log To The ConnectUsLog.txt file
     */
    public void keepLog(String logText, String functionType) {
        try (FileWriter fileWrite = new FileWriter("src/test/data/XMLUtilTest/ConnectUsLog.txt", true);
             BufferedWriter buffWriter = new BufferedWriter(fileWrite);
             PrintWriter out = new PrintWriter(buffWriter)) {
            out.println(functionType + "\t" + logText + "\t" + LocalDateTime.now() + "\n");
        } catch (IOException e) {
            System.out.println("Error With ConnectUs.txt Logging");
        }
    }
    /**
     * clearLog Method to clear the Activity Log in the ConnectUsLog.txt file
     */
    public void clearLog() {
        File file = new File("src/test/data/XMLUtilTest/ConnectUsLog.txt");
        file.delete();
    }
    /**
     * startUpLog Method will record the time when the application starts
     */
    public void startUpLog() {
        try (FileWriter fileWrite = new FileWriter("src/test/data/XMLUtilTest/ConnectUsLog.txt", true);
             BufferedWriter buffWriter = new BufferedWriter(fileWrite);
             PrintWriter out = new PrintWriter(buffWriter)) {
            out.println("Application Started on " + LocalDateTime.now());
        } catch (IOException e) {
            System.out.println("Error With ConnectUs.txt Logging");
        }
    }
}
```
###### \java\seedu\address\logic\commands\QrCommand.java
``` java
public class QrCommand {
    /**
     * Method to Generate PhoneCall QRCode
     */
    public String qrCall(String phoneNum) {
        String qrCodeA = "http://api.qrserver.com/v1/create-qr-code/?color=000000&bgcolor=FFFFFF&data=tel%3A";
        String qrCodeB = "&qzone=1&margin=0&size=150x150&ecc=L";
        String fullQr = qrCodeA + phoneNum + qrCodeB;
        return fullQr;
    }
}
```
