package NotebookShop;

import java.util.List;


interface IntNotebookDao {
    public boolean AddNotebook();

    public List<notebookslist> ShowList();

    public boolean DeleteNotebook();

    public boolean UpdatePrice();

    public boolean UpdateSerialVendor();

    public boolean DeleteNotebookByName();

    public List<notebookslist> ShowListByVendor();

    public List<notebookslist> ShowListByPrice();

    public List<notebookslist> ShowListByDatePrice();
}



