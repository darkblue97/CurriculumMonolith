pipeline {
    agent any
    stages{
        stage("RUN"){
            steps{
                echo "executing gradle"
                withGradle(){
                    sh './gradlew build'
                }
            }
        }
        stage("SONAR"){
            environment {
                scannerHome = tool 'sonarqube'
            }

            steps{
                echo "Executing Sonar"
                withSonarQubeEnv('sonarqube') {
                    sh "./gradlew sonarqube"
                }
            }
        }
    }
}