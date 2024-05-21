    package org.example;
    import ru.pflb.mq.dummy.implementation.ConnectionImpl;
    import ru.pflb.mq.dummy.implementation.DestinationImpl;
    import ru.pflb.mq.dummy.implementation.ProducerImpl;
    import ru.pflb.mq.dummy.interfaces.Connection;
    import ru.pflb.mq.dummy.interfaces.Session;
    import java.io.BufferedReader;
    import java.io.FileReader;
    import java.util.concurrent.TimeUnit;

public class Task2 {
    public static void main(String[] args) {
        System.out.println("Укажите путь до файла: ");
        try {
           Connection connection = new ConnectionImpl();
           Session session = connection.createSession(true);
           DestinationImpl destination = new DestinationImpl("MyQueue2");
           ProducerImpl producer =  new ProducerImpl(destination);
      boolean infinity = true;
      while (infinity) {
          BufferedReader reader = new BufferedReader(new FileReader(args[0]));
          while (reader.ready()) {
              producer.send(reader.readLine());
              TimeUnit.SECONDS.sleep(2);
                                          }
                                }
       }
       catch (Exception e) {
           e.printStackTrace();
  }
    }
}

