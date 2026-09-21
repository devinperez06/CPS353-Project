package apidemo.datastore;

public class PrototypeDataStore {
    public void prototype(DataStore dataStore) {
        // store some data
        DataStorageResponse storeResponse = dataStore.storeData(new DataStorageRequest());
        // retrieve the data
        DataLoadResponse loadResponse = dataStore.loadData(storeResponse.getDataKey());
    }
}
