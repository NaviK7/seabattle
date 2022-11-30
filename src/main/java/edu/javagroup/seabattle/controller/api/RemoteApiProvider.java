package edu.javagroup.seabattle.controller.api;

import java.util.Optional;

public interface RemoteApiProvider {

    Optional<RemoteApi> getRemoteApi();
}
