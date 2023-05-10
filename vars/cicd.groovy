def newGit(repo)
{
  git "https://github.com/intelliqittrainings/${repo}"
}

def newMaven
{
  sh 'mvn package' 
} 
def newDeploy("jobname","ipaddress","context")
{
  sh "scp /var/lib/jenkins/workspace/${jobname}/webapp/target/webapp.war ubuntu@${ipaddress}:/var/lib/tomcat9/webapps/${context}.war"
} 
def runSelenium(jobname)
{
  sh "java -jar /var/lib/jenkins/workspace/${jobname}/testing.jar"
}  
def newApproval(name)
{
   input message: 'Waiting for Approval', submitter: "${name}"  
} 
