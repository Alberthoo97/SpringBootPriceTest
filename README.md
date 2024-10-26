<!DOCTYPE html>
<html lang="en">
<body>

<h1>Spring Boot Prices Application</h1>

<p>Welcome to the <strong>Spring Boot Prices Application</strong>! This README provides instructions for setting up, running, and testing the application. This project is built with <strong>Spring Boot</strong> using <strong>Java</strong>, <strong>Maven</strong> as the build tool, and an <strong>in-memory H2 database</strong>.</p>

<h2>Table of Contents</h2>
<ul>
  <li><a href="#getting-started">Getting Started</a></li>
  <li><a href="#prerequisites">Prerequisites</a></li>
  <li><a href="#installation">Installation</a></li>
  <li><a href="#running-the-application">Running the Application</a></li>
  <li><a href="#h2-database-console">H2 Database Console</a></li>
  <li><a href="#folder-structure">Folder Structure</a></li>
</ul>

<h2 id="getting-started">Getting Started</h2>
<p>To set up this application, make sure you have Java and Maven installed. The application runs an H2 in-memory database that will initialize each time the application starts.</p>

<h3 id="prerequisites">Prerequisites</h3>
<ul>
  <li><strong>Java JDK 11 or later</strong>: Download from <a href="https://www.oracle.com/java/technologies/javase-downloads.html">Oracle</a></li>
  <li><strong>Maven</strong>: Download and install from <a href="https://maven.apache.org/download.cgi">Maven</a></li>
</ul>

<h3 id="installation">Installation</h3>
<p>Clone this repository and navigate to the project directory. Build the project using Maven:</p>
<pre><code>git clone https://github.com/Alberthoo97/SpringBootPriceTest.git
cd &lt;project-directory&gt;
mvn clean install</code></pre>

<h2 id="running-the-application">Running the Application</h2>
<p>To start the Spring Boot application, run:</p>
<pre><code>mvn spring-boot:run</code></pre>
<p>Or you can start it by executing the compiled JAR file located in the <code>target/</code> folder:</p>
<pre><code>java -jar target/SpringBootPrices.jar</code></pre>

<p>The application will start on <code>http://localhost:8080</code> by default.</p>

<h2 id="h2-database-console">H2 Database Console</h2>
<p>The application uses an in-memory H2 database, which you can access through the H2 Console. To access the console, go to:</p>
<p><code>http://localhost:8080/h2-console</code></p>
<p>Use the following settings to connect:</p>
<ul>
  <li><strong>JDBC URL</strong>: <code>jdbc:h2:mem:testdb</code></li>
  <li><strong>Username</strong>: <code>sa</code></li>
  <li><strong>Password</strong>: (leave blank)</li>
</ul>

<h2 id="folder-structure">Folder Structure</h2>
<p>The main structure of this project is as follows:</p>
<pre><code>src/
├── main/
│   ├── java/                  # Java source files
│   ├── resources/
│   │   ├── application.properties # Spring Boot configuration file
├── test/                         # Test cases
└── pom.xml                       # Maven build file</code></pre>

</body>
</html>
