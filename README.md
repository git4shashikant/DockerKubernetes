# DockerKubernetes
Approach-1: Using Azure deployment center from Kubernetes cluster Azure web page  
- This uses github as code repository and azure container registry as image repository.
- Files inside ".github/workflows" and "menifest" folders are automatically created while deploying through "Azure Deployment center". 
These files can be edited later to change the names or parameters.
- workflow file is used in Actions to deploy the changes directly in Kubernetes cluster.

Approach-2: Using pipleine yaml file
- ss-kube-ci.yaml is the pipline file having tasks to build and deploy artifacts.
- this approach is using github as code repository and docker hub as image repository.
- we need to create git, kubernetes connections and environment to run this pipeline.
- This approach is using kubernetes-deployment.yaml and kubernetes-service.yaml as menifest files.

