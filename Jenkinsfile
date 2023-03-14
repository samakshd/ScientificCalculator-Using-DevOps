pipeline {
    // Declare variables that will be used by the later stages
    environment {
        DOCKERHUB_REGISTRY = "jasvinjames/calculator-using-devops"
        DOCKERHUB_CREDENTIALS = credentials('dockerhub-id')
    }
    
    // The "agent" section configures on which nodes the pipeline can be 
    // run. Specifying "agent any" means that Jenkins will run the job on  
    // any of the available nodes.
    agent any 
    
    stages {
        
        stage('Git Pull') {
            steps {
                // credentials are required because its a private repository
                git url: 'https://github.com/james-jasvin/Calculator-Using-DevOps.git',
                branch: 'master',
                credentialsId: 'github-pat'
            }
        }
        
        stage('Maven Build + JUnit Tests') {
            steps {
                sh 'mvn clean install'
            }
        }
    }
}

