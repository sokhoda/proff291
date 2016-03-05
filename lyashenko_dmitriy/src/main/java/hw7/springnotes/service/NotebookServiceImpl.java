package hw7.springnotes.service;



import hw7.springnotes.dao.*;
import hw7.springnotes.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Admin on 17.02.2016.
 */

@Service("NotebookService")
@Transactional
public class NotebookServiceImpl implements NotebookService {

    @Autowired
    private CPUDao cpuDao;
    @Autowired
    private MemoryDao memoryDao;
    @Autowired
    private NotebookDao notebookDao;
    @Autowired
    private SalesDao salesDao;
    @Autowired
    private StoreDao storeDao;
    @Autowired
    private VendorDao vendorDao;




    public NotebookServiceImpl(){}

    public NotebookServiceImpl(String key){

        this.cpuDao = new CPUDaoImpl();
        this.memoryDao = new MemoryDaoImpl();
        this.notebookDao = new NotebookDaoImpl();
        this.salesDao = new SalesDaoImpl();
        this.storeDao = new StoreDaoImpl();
        this.vendorDao = new VendorDaoImpl();

    }


    @Override
    public Long receive(Long noteId, int amount, double price) {
        Store store = new Store(notebookDao.read(noteId), amount,price);
        return storeDao.create(store);
    }

    @Override
    public Long sale(Long storeId, int amount) {
        Date date =  new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
        Store store = storeDao.read(storeId);
        store.setQuantity(store.getQuantity() - amount);
        store.setPrice(store.getPrice() - (store.getPriseForOne() * amount));
        storeDao.update(store);
        Sales sales = new Sales(store ,simpleDateFormat.format(date),amount);
        Long id = salesDao.create(sales);

        return id;
    }

    @Override
    public boolean updateCPU(CPU cpu) {
        return cpuDao.update(cpu);
    }

    @Override
    public boolean updateMemory(Memory memory) {
        return memoryDao.update(memory);
    }

    @Override
    public boolean updateVendor(Vendor vendor) {
        return vendorDao.update(vendor);
    }

    @Override
    public boolean updateNotebook(Notebook notebook) {
        return notebookDao.update(notebook);
    }

    @Override
    public boolean removeFromStore(Store store, int amount) {
        store = storeDao.read(store.getId());
        store.setQuantity(store.getQuantity() - amount);
        store.setPrice(store.getPrice() - (amount * store.getPriseForOne()));
        return storeDao.update(store);
    }

    @Override
    @Transactional(readOnly = true)
    public List getNotebooksByPortion(int size) {

        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List getNotebooksGtAmount(int amount) {
        return storeDao.getNotebooksGtAmount(amount);
    }

    @Override
    @Transactional(readOnly = true)
    public List getNotebooksByCpuVendor(Vendor cpuVendor) {
        List<Notebook> allNotes = notebookDao.findAll();
        List<Notebook> allCpuVendor = new ArrayList<Notebook>();

        for (int i = 0; i < 0; i++){
            if(allNotes.get(i).getCpu().getVendorCPU().getName().equalsIgnoreCase(cpuVendor.getName())){
                allCpuVendor.add(allNotes.get(i));
            }
        }
               return allCpuVendor;
    }

    @Override
    @Transactional(readOnly = true)
    public List getNotebooksFromStore() {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public Map getNotebooksStorePresent() {
        Map<Vendor, Notebook> nnn = new HashMap<Vendor, Notebook>();
        return nnn;
    }

    @Override
    @Transactional(readOnly = true)
    public Map getSalesByDays() {

        return salesDao.getSalesByDays();
    }

    public CPUDao getCpuDao() {
        return cpuDao;
    }

    public void setCpuDao(CPUDao cpuDao) {
        this.cpuDao = cpuDao;
    }

    public MemoryDao getMemoryDao() {
        return memoryDao;
    }

    public void setMemoryDao(MemoryDao memoryDao) {
        this.memoryDao = memoryDao;
    }

    public NotebookDao getNotebookDao() {
        return notebookDao;
    }

    public void setNotebookDao(NotebookDao notebookDao) {
        this.notebookDao = notebookDao;
    }

    public SalesDao getSalesDao() {
        return salesDao;
    }

    public void setSalesDao(SalesDao salesDao) {
        this.salesDao = salesDao;
    }

    public StoreDao getStoreDao() {
        return storeDao;
    }

    public void setStoreDao(StoreDao storeDao) {
        this.storeDao = storeDao;
    }

    public VendorDao getVendorDao() {
        return vendorDao;
    }

    public void setVendorDao(VendorDao vendorDao) {
        this.vendorDao = vendorDao;
    }
}
