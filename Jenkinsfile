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
             sh " mvn sonar:sonar -Dsonar.projectKey=spring -Dsonar.host.url=http://192.168.1.105:9000   -Dsonar.login=130f1b9a120c51d6a0234fd6b519d1dab11ecc4a"

                }
            }
        }
 stage("publish to nexus") {
            steps {
                script {
                configFileProvider([configFile(fileId: 'mohamed', variable: 'setting')]) {
                    sh 'mvn  -B -DskipTests deploy -s $setting'

                         } 
                        }
                   }
        }
            
    }   
}
