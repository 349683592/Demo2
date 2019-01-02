package com.offcn.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.offcn.pojo.Mobile;
import com.offcn.service.MobileService;

public class MoblieUtil {


	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		MobileService service = context.getBean(MobileService.class);
		Workbook workbook = WorkbookFactory.create(new File("E:\\lol\\Mobile.xls"));
		//获取表格数量
		int sheets = workbook.getNumberOfSheets();
		for (int i = 0; i < sheets; i++) {
			Sheet sheet = workbook.getSheetAt(i);
			//获取表格中有数据的行
			int rows = sheet.getPhysicalNumberOfRows();
			List<Mobile> list = new ArrayList<Mobile>();
			for (int j = 0; j < rows; j++) {
				Row row = sheet.getRow(j);
				//获取每行的单元格数量
				int cells = row.getPhysicalNumberOfCells();
				StringBuffer buffer = new StringBuffer();
				for (int k = 0; k < cells; k++) {
					Cell cell = row.getCell(k);
					if(cell.getCellTypeEnum()==CellType.STRING){
						buffer.append(cell.getStringCellValue()+"-");
					}
					if(cell.getCellTypeEnum()==CellType.NUMERIC){
						buffer.append(cell.getNumericCellValue()+"-");
					}
				}
				
				//获取到了一行内容
				String[] ss = buffer.toString().split("-");
				Mobile m = new Mobile();
				m.setMobilenumber(ss[1]);
				m.setMobilearea(ss[2]);
				m.setMobiletype(ss[3]);
				m.setAreacode(ss[4]);
				m.setPostcode(ss[5]);
				list.add(m);
				if(list.size()==1000){
					service.saveMobile(list);
					list.clear();
				}
			}
			
			if(list.size()>0){
				service.saveMobile(list);
				list.clear();
			}
			
		}
		workbook.close();
	}

}
