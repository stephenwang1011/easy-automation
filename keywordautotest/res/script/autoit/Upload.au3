;first make sure the number of arguments passed into the scripts is more than 1
If $CmdLine[0]<2 Then Exit EndIf ;if parmas num <2 ,then break
;$CmdLine[0] ;����������
;$CmdLine[1] ;��һ������ (�ű����ƺ���)
;$CmdLine[2] ;�ڶ�������
 handleUpload($CmdLine[1],$CmdLine[2])

;define a function to handle upload
 Func handleUpload($browser, $uploadfile)
	 Dim $title                          ;declare a variable
            ;specify the upload window title according to the browser
            If $browser="ie" Then                  		; stands for IE;
				  $title="ѡ��Ҫ���ص��ļ�"
			ElseIf $browser="chrome" Then               ; stands for chrome
				 $title="��"
			ElseIf	$browser="firefox" Then 			; stands for firefox
				  $title="�ļ��ϴ�"
            EndIf

            if WinWait($title,"",4) Then ;wait for window withtitle attribute for 4 seconds;
                   WinActivate($title)                  ;active the window;
                   ControlSetText($title,"","Edit1",$uploadfile)   ;put thefile path into the textfield
                   ControlClick($title,"","Button1")                ;click the OK or Save button
            Else
	        Return False
            EndIf
 EndFunc