pipeline {
    agent any


   tools {
        jdk '11 (OpenJDK)'
        maven '4.0.0'
   }

    environment {
        // Define your Maven and Java versions
        JAVA_HOME = tool 'JDK11'
        MAVEN_HOME = tool 'Maven'
        PATH = "${MAVEN_HOME}/bin:${JAVA_HOME}/bin:${env.PATH}"
    }

    stages {
        stage('Checkout') {
            steps {
                // Check out the code from your VCS
                checkout scm
            }
        }

        stage('Build') {
            steps {
                // Build the Spring Boot application using Maven
                sh 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                // Run tests (if any) for your Spring Boot application
                sh 'mvn test'
            }
        }

        stage('Deploy') {
            steps {
                // Deploy the Spring Boot application ()Jar or War to server)
                // Modify this step based on your deployment strategy
                // For example, you might deploy to a Tomcat Application-Server or use Docker
                // Here, we're just copying the JAR to a hypothetical deployment directory
                sh 'cp target/SpringToDoApp-0.0.1-SNAPSHOT.jar /path/to/deployment/directory/'
            }
        }
    }

    post {
        success {
            // Add any post-build steps here, such as notifications
            echo 'Build and deployment successful!'
        }
        failure {
            // Add any post-failure steps here, such as notifications or cleanup
            echo 'Build or deployment failed!'
        }
    }
}
