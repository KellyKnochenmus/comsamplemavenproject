node('qa') {
  try {
    notifyBuild('STARTED')

    stage 'Checkout'
    checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'c480aef3-a634-4247-91c1-39ebb7c589c4', url: 'https://github.com/KellyKnochenmus/comsamplemavenproject']]])

    stage 'Test'
    sh 'scripts/Jenkinsfile'
  } catch (e) {
    currentBuild.result = "FAILURE"
    throw e
  } finally {
    notifyBuild(currentBuild.result)
  }
}

def notifyBuild(String buildStatus = 'STARTED') {
  // build status of null means successful
  buildStatus =  buildStatus ?: 'SUCCESSFUL'

  summary = "${buildStatus}: ${env.JOB_NAME} [${env.BUILD_NUMBER}] (${env.BUILD_URL})"

  if (buildStatus == 'STARTED') {
    colorCode = 'warning'
  } else if (buildStatus == 'SUCCESSFUL') {
    colorCode = 'good'
  } else {
    colorCode = 'danger'
  }

}
