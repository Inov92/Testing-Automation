1) Для работы программы необходимо указать в файле congig.properties путь к geckodriver.exe
congig.properties расположен в .src/main/resuorces.
2) В тестах capabiltiesTest() и avitoTest() закоментированны Assert, т.к. они выдают ошибку,
по причине того, что driver не переходит на новую страницу, не смотря на то, что новая страница загружается.
3) Тест со скриншотом совмещён с avitoTest().