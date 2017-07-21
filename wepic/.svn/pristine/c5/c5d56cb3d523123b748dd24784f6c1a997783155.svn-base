function getpos(e){
	    var t=$(e).offset().top -100; 
	   
	  //  alert(t);
	    goErrorTopEx(t);
	} 

	/////////////////////////////////////////////////////////////
	function goErrorTopEx(value){
		
	    function getScrollTop(){
			if(document.documentElement.scrollTop)
	        	{
				return document.documentElement.scrollTop;
				}
			else	
				{
				return document.body.scrollTop}
	        }
		
	    function setScrollTop(value){
			if(document.documentElement.scrollTop)
	        	{document.documentElement.scrollTop = value;}
			else	
				{document.body.scrollTop = value;}
	        }    
		
	        var goTop=setInterval(scrollMove,10);
	        function scrollMove(){
	                setScrollTop(getScrollTop()/1.1);
			        
	                if(getScrollTop()<value)
	                	clearInterval(goTop);
	            }
	    }
