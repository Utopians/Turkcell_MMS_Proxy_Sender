Turkcell_MMS_Proxy_Sender
=========================

java -jar Turkcell_MMS_Proxy_Sender.jar paket.xml Path+icerik_klasoru<br />
paket.xml, icerik_klasorunun icinde olmali ve parametrede path belirtilmemeli;

Recep Cinet<br />
TEKNOmart<br />
<a href='www.mesajservisi.com' target='_blank'>www.mesajservisi.com</a>

paket.xml (Turkcell'in istedigi XML yapisi)<br />
```
<?xml version="1.0" encoding="UTF-8"?>
<SubmitReq xmlns="http://www.3gpp.org/ftp/Specs/archive/23_series/23.140/schema/REL-5-MM7-1-3" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://www.3gpp.org/ftp/Specs/archive/23_series/23.140/schema/REL-5-MM7-1-3">
<MM7Version>5.6.0</MM7Version>
<SenderIdentification>
<VASPID>USER:PASS</VASPID>
<VASID>VARIANT:1:0</VASID>
<SenderAddress>
<Number>SENDER</Number>
</SenderAddress>
</SenderIdentification>
<Recipients>
<To><Number>5320000000</Number></To>
<To><Number>5320000001</Number></To>
<To><Number>5320000002</Number></To>
</Recipients>
<Subject>TEST</Subject>
</SubmitReq>
```
icerik_klasoru: (Bazi telefonlar icin mutlaka smil dosyasina saniye girmelisiniz (par dur=15), mesela Samsung Galaxy S3'lerde smil dosyasi olmazsa videolarin yarim kesebiliyor.)<br />
smil.smil file:<br />
```
<?xml version="1.0" encoding="utf-8"?>
<smil>
<head>
<layout>
<region id="icerik" top="0" left="0" height="100%" width="100%" fit="meet" />
</layout>
</head>
<body>
<par dur="15">
<video src="test.3gp" region="icerik" />
</par>
</body>
</smil>
```
