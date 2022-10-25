pipeline {
    agent any
      stages {
        stage("getting code from SCM ") {
            steps {
                script {
               checkout([$class: 'GitSCM', branches: [[name: '*/mohamed']], extensions: [], userRemoteConfigs: [[credentialsId: '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', url: 'https://github.com/Chiheb97/Jenkins-spring-CI.git']]])
                }
            }
        }
       stage("cleaning code") {
            steps {
                script {
                   sh 'mvn -B -DskipTests clean '
                }
            }
        }
        stage("building") {
            steps {
                script {
                   sh 'mvn -B -DskipTests clean package'
                }
            }
        }
         stage("testing") {
            steps {
                script {
                   sh 'mvn test'
                }
            }
        }
        stage("code QualityCheck Sonar") {
            steps {
                script {
             sh " mvn sonar:sonar -Dsonar.projectKey=spring -Dsonar.host.url=http://localhost:9000   -Dsonar.login=0b774d2076672ea6a07361ca5f349cf2007d6848"

                }
            }
        }
  stage("DEPLOY") {
            steps {
				
                sh "mvn clean install deploy:deploy-file -DskipTests  -DgroupId=com.esprit.examen -DartifactId=tpAchatProject -Dversion=1.0 -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://localhost:8081/repository/maven-releases/ -Dfile=target/tpAchatProject-1.0.jar"
            }
        }
               stage("building docker image") {
            steps {
                script {
                   sh 'docker build -t mannai3/spring:firsttry .'
                }
            }
        }
        
         
        stage("test push docker hub") { 
             steps { 
                 script { 
                    withCredentials([usernamePassword(credentialsId: 'dockerhub', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
                    sh "echo $PASS | docker login -u $USER --password-stdin"
                    sh 'docker push mannai3/spring:firsttry'
                        
                    }
                 } 
             } 
         } 
	      
	      stage("test docker compose ") {
            steps {
                script {
                  sh 'docker compose up -d '
                }
            }
        }
    }   
}
