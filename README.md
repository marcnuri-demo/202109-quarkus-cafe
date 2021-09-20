202109 Quarkus Cafe demo
========================

### Common files

The Java sources and resources for the project are in the `common/java` and 
`common/resources` directories which are soft-linked in each of the project variants.

### Vanilla Quarkus

1. Local Dev
    `mvn quarkus:dev`


### Vanilla Quarkus with odo

1. Create a configuration describing a component.
    `odo create vanilla-odo --devfile devfile.yaml`
2. Push source code to a component.
    `odo push --show-log`
3. Check the URL endpoint
    `odo url list`
4. Set Quarkus Dev Mode
    `odo config set -e QUARKUS_LAUNCH_DEVMODE=true`
5. Remote & Debug mode
    `odo push --debug`
5. Debug mode port forward 
    `odo debug port-forward`
6. Quarkus Remote Dev
    `mvn quarkus:remote-dev -Dquarkus.live-reload.password=123 -Dquarkus.live-reload.url=http://vanilla-odo-8080-app-mmascia-dev.apps.sandbox-m2.ll9k.p1.openshiftapps.com`

### Eclipse JKube

(different packaging strategies)

Low configuration effort
Base image is good for inner-loop

#### Inner-Loop

Local development in mnurisan-dev namespace
- ConfigMap fragment from jkube/dev
- Generate images with S2I (oc:build)

#### Outer-Loop

Prod environment in mnurisan-stage namespace
- ConfigMap fragment from jkube/prod
- Generate images (with JIB) in native mode and deploy them to Quay
- Generate manifests and persist in repo?
- Generate Helm charts?
- Push Helm charts?
- Deploy to Sandbox using quay image
- GH Actions workflow