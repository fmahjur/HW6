package repository;

public class PlayerRepository {
    private static PlayerRepository instance = new PlayerRepository();
    private PlayerRepository(){}
    private static PlayerRepository getInstance(){
        return instance;
    }
}
