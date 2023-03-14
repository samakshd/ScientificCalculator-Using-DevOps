pipeline {    
    // The "agent" section configures on which nodes the pipeline can be 
    // run. Specifying "agent any" means that Jenkins will run the job on  
    // any of the available nodes.
    agent any 
    
    stages {
        
        stage('Git Pull') {
            steps {
                // credentials are required because its a private repository
                git url: 'https://github.com/samakshd/ScientificCalculator-Using-DevOps.git',
                branch: 'master',
                credentialsId: 'c8c63ab8-2222-4e55-9c03-ceb350db4db0'
            }
        }
        
        stage('Maven Build + JUnit Tests') {
            steps {
                sh 'mvn clean install'
            }
        }
    }
}

