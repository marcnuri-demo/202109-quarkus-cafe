202109 Quarkus Cafe demo
========================

### Common files

The Java sources and resources for the project are in the `common/java` and 
`common/resources` directories which are soft-linked in each of the project variants.

### Vanilla Quarkus

### Vanilla Quarkus with odo

1. Create a configuration describing a component.
    `odo create vanilla-odo --devfile devfile.yaml`
2. Push source code to a component.
    `odo push --show-log`
3. Check the URL endpoint
    `odo url list`
4. Debug mode
    `odo push --debug`

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