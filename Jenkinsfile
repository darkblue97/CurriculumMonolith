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
                scannerHome = tool 'SonarQubeScanner'
            }

            steps{
                echo "Executing Sonar"
                withSonarQubeEnv('sonarqube') {
                    sh "${scannerHome}/bin/sonar-scanner"
                }
            }
        }
    }
}