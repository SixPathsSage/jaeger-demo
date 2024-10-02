FROM quay.io/keycloak/keycloak:nightly

COPY keycloak.conf /opt/keycloak/conf

RUN /opt/keycloak/bin/kc.sh build
ENTRYPOINT ["/opt/keycloak/bin/kc.sh", "start-dev"]