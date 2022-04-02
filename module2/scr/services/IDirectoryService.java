package services;

import model.TelephoneDirectory;
import java.util.List;

public interface IDirectoryService {
    List<TelephoneDirectory> getItem();
    void add(TelephoneDirectory telephoneDirectory);
    void update();
    void remove(DirectoryService directoryService);
    void search();
    boolean isFullNameHaveInList(String name);
    boolean getDirectoryByName(String name);
}
