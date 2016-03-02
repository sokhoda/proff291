package hw7.notes.service;

import hw7.notes.domain.CPU;
import hw7.notes.domain.Memory;
import hw7.notes.domain.Notebook;
import hw7.notes.domain.Vendor;

import java.sql.Date;
import java.util.List;

/**
 * Created by Solyk on 25.02.2016.
 */
public class Menu {
    public static void main(String[] args) {
        Vendor vv = new Vendor("Samsung");
        Vendor cpp = new Vendor("Intel");
        Vendor cmeC = new Vendor("Shara");
        Date manufactoreDate = Date.valueOf("2014-10-10");
        CPU cpu = new CPU(cpp,2.7,"i5");
        Memory mem = new Memory(cmeC,8);

        Notebook notebook = new Notebook(vv,"Aspire",manufactoreDate,cpu,mem);


        NotebookServiceImpl cocp = new NotebookServiceImpl("key");
//        Long cpuId = cocp.getCpuDao().create(new CPU(cocp.getVendorDao().read(2L),2.7,"i5"));
//        Long memId = cocp.getMemoryDao().create(new Memory(cocp.getVendorDao().read(1L), 8));
//        System.out.print( cocp.getNotebookDao().create(new Notebook(cocp.getVendorDao().read(1L), "Aspire", manufactoreDate,
//               cocp.getCpuDao().read(cpuId), cocp.getMemoryDao().read(memId) )));
//      System.out.print( cocp.getNotebookDao().create(notebook));
     //  System.out.print( cocp.getMemoryDao().create(new Memory(cocp.getVendorDao().read(1L), 8)));
//        System.out.print( cocp.getVendorDao().create(cpp));

       List<Notebook> lo =  cocp.getNotebooksByCpuVendor(cocp.getVendorDao().read(2L));

        for (int i = 0; i < lo.size(); i++){
            System.out.print(lo.get(i).toString());
        }
    }
}
