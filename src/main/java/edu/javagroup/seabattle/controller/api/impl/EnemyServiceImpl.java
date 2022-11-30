package edu.javagroup.seabattle.controller.api.impl;

import edu.javagroup.seabattle.controller.api.EnemyService;
import edu.javagroup.seabattle.controller.api.RemoteApi;
import edu.javagroup.seabattle.controller.api.RemoteApiProvider;
import edu.javagroup.seabattle.singleton.SettingsSingleton;
import edu.javagroup.seabattle.util.StringUtils;
import org.springframework.stereotype.Component;
import retrofit2.Call;

import java.io.IOException;
import java.util.Optional;

import static edu.javagroup.seabattle.constants.Constants.ENEMY_IP_ADDRESS;

@Component
public class EnemyServiceImpl implements EnemyService {

    private Optional<RemoteApi> remoteApiOptional;
    private final RemoteApiProvider remoteApiProvider;

    public EnemyServiceImpl(RemoteApiProvider remoteApiProvider) {
        this.remoteApiProvider = remoteApiProvider;
    }

    public void setRemoteApiOptional() {
        String enemyIpAddress = SettingsSingleton.instance(null).getSettingsByKey(ENEMY_IP_ADDRESS);
        remoteApiOptional = StringUtils.isNotEmpty(enemyIpAddress) ?
                remoteApiProvider.getRemoteApi() :
                Optional.empty();
    }

    //------------------------------------------------------------------------------------------------------------------

    @Override
    public Boolean lanTest() {
        setRemoteApiOptional();
        if (remoteApiOptional.isPresent()) {
            Call<Boolean> call = remoteApiOptional.get().lanTest();
            try {
                return call.execute().body();
            } catch (IOException e) {
                System.out.println("Error: " + this.getClass().getSimpleName() + " - " + e.getMessage());
                //JOptionPane.showMessageDialog(null, "Проблема с сетью", "Ошибка!", JOptionPane.ERROR_MESSAGE);
            }
        }
        return false;
    }

    @Override
    public Boolean areYouReady() {
        setRemoteApiOptional();
        if (remoteApiOptional.isPresent()) {
            Call<Boolean> call = remoteApiOptional.get().areYouReady();
            try {
                return call.execute().body();
            } catch (IOException e) {
                System.out.println("Error: " + this.getClass().getSimpleName() + " - " + e.getMessage());
                //JOptionPane.showMessageDialog(null, "Проблема с сетью", "Ошибка!", JOptionPane.ERROR_MESSAGE);
            }
        }
        return false;
    }

    @Override
    public Boolean sendBomb(int row, int col) {
        setRemoteApiOptional();
        if (remoteApiOptional.isPresent()) {
            Call<Boolean> call = remoteApiOptional.get().sendBomb(row, col);
            try {
                return call.execute().body();
            } catch (IOException e) {
                System.out.println("Error: " + this.getClass().getSimpleName() + " - " + e.getMessage());
                //JOptionPane.showMessageDialog(null, "Проблема с сетью", "Ошибка!", JOptionPane.ERROR_MESSAGE);
            }
        }
        return false;
    }
}
