import xlrd
import xlsxwriter
import xlwt
import os
import time

#遍历文件夹后缀名xlsx文件
def listfiles(rootdir, prefix='.xlsx', isall=False, iscur=False):
    file = []
    for parent, dirnames, filenames in os.walk(rootdir):
        if parent == rootdir:
            for filename in filenames:
                if filename.endswith(prefix):
                    if isall:
                        file.append(rootdir + '/' + filename)
                    else:
                        file.append(filename)
            if not iscur:
                return file
        else:
            if iscur:
                for filename in filenames:
                    if filename.endswith(prefix):
                        if isall:
                            file.append(rootdir + '/' + filename)
                        else:
                            file.append(filename)
            else:
                pass
    return file

#遍历工作簿内的所有的sheet名称
def getSheetNames(path):
    listSheetNames = []
    l = listfiles(path)[0]
    lsn = xlrd.open_workbook(l)
    for i in range(0,len(lsn.sheets())):
        cell= lsn._sheet_names[i]
        listSheetNames.append(cell)
    return  listSheetNames

#读取数据
def getWriteData(sheet):
    xlsxinfo = []
    nrows = sheet.nrows
    for rownum  in range(5,nrows):
        if (rownum == 5 or rownum == 7) :
            cell = sheet.row_values(rownum )
            if cell :
                xlsxinfo.append(cell)
    return xlsxinfo

#写入数据
def writeToOneExcel(path,toExcelName=''):
    targetBook = xlsxwriter.Workbook(toExcelName)
    listxlsx = listfiles(path)
    targetsheet =targetBook.add_worksheet("内场化验")
    rownum = 0
    columnnum = 0
    for i in listxlsx:
        wb = xlrd.open_workbook(i)
        sheets = wb.sheets()
        for a in sheets:

            data = []
            data = getWriteData(a)
            for x in range(0,len(data)):
                arr =  data[x]
                for b in range(0,len(arr)):
                    targetsheet.write(rownum, columnnum, arr[b])
                    columnnum = columnnum + 1
                    if columnnum > a.ncols - 1:
                        columnnum = 0
                        rownum = rownum + 1
    targetBook.close()

def main():
    path = os.getcwd()#获取路径
    toExcelName = path + "\\内场化验.xlsx"#汇总表名称
    writeToOneExcel(path, toExcelName)

if __name__ == "__main__":
    main()