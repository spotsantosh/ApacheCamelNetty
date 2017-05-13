Producer Consumer application using Apache Camel Netty
------------------------------------------------------
Apache Camel is a versatile open-source integration framework based on known Enterprise Integration Patterns. Apache Camel is an open source framework developed in Java, it focuses on making integration easier. It provides concrete implementaions of all widely used components like File, CXF, FTP, JMS, SMTP, Twitter, Yammer and many more.
Netty is a widely used socket library that greatly simplifies network programming using TCP and UDP sockets. Apache Camel provides Netty component out of the box that can be used tor sending and receiving data over sockets.

The puropse of this project is to demonstrates capabilities of Apache Camel as a tool for enterprise integration. The project demonstrates sending and receiving stock price messages over sockets. The Producer application loads price information from a local csv file, binds csv data to a java object (POJO) and send the messages over socket. The COnsumer application receives messages over socket and prints them.

Message Flow:
-------------

 +---------+   +------------+   +-----+   +------------+    +-----------+   +-----+
 | csv file|-->|bind to POJO|-->|split|-->|socket write|===>|socket read|-->|print|
 +---------+   +------------+   +-----+   +------------+    +-----------+   +-----+


Data File:
---------
The project uses historical data for AAPL stock (1 minute), downloaded from http://thebonnotgang.com/tbg/historical-data/
NASDAQ AAPL from 20150101 to 21070501 (about 16mb)
ls -lh /home/santosh/workspace/ApacheCamelNetty/market_data/AAPL_1m_2015-01-01_2017-05-01.csv 
-rw-rw-r-- 1 santosh santosh 16M May 13 09:53 /home/santosh/workspace/ApacheCamelNetty/market_data/AAPL_1m_2015-01-01_2017-05-01.csv

Output:
-------
 Received 10000th	 msg:QuoteData [symbol=AAPL, seqNumber=10000] After 6848ms.
 Received 20000th	 msg:QuoteData [symbol=AAPL, seqNumber=20000] After 11569ms.
 Received 30000th	 msg:QuoteData [symbol=AAPL, seqNumber=30000] After 14122ms.
 . . .
 Received 200000th	 msg:QuoteData [symbol=AAPL, seqNumber=200000] After 53893ms.
 Received 210000th	 msg:QuoteData [symbol=AAPL, seqNumber=210000] After 56319ms.
 Received 220000th	 msg:QuoteData [symbol=AAPL, seqNumber=220000] After 58820ms.
 Received 230000th	 msg:QuoteData [symbol=AAPL, seqNumber=230000] After 61051ms.
 -- Around 3767 messages per second.

Conclusion:
-----------
Apache Camel provides a robust enterprise integration framework, developers should definitely include it in their tool box.  
Throughput observer was about 3767 messages per second, on the same machine. Throughput may vary based on network configuration.
