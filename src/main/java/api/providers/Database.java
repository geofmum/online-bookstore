package api.providers;

import io.ebean.EbeanServer;
import io.ebean.EbeanServerFactory;
import io.ebean.config.ServerConfig;
import io.ebean.datasource.DataSourceConfig;

public enum Database {
    INSTANCE;

    private static EbeanServer server;

    public void initialize(String dbfile) {
        DataSourceConfig ds = new DataSourceConfig();
        ds.setUrl("jdbc:sqlite:" + dbfile);

        ServerConfig config = new ServerConfig();
        config.setName("db");
        config.setDataSourceConfig(ds);
        config.setDefaultServer(true);
        config.loadFromProperties();

        EbeanServer server = EbeanServerFactory.create(config);
    }

    public EbeanServer getServer (){
        return server;
    }
}
