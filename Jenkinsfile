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
            steps{
                echo "Executing Sonar"
            }
        }
    }
}