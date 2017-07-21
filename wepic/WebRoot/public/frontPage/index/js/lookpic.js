;(function($){
$.fn.lookpic=function(options){
	var opt={
		thumWidth:110,              
		thumGap:8,                 
		thumMoveStep:5,             
		moveSpeed:300,              
		fadeSpeed:300,              
		end:''
	}
	$.extend(opt,options);
	return this.each(function(){
		var $this=$(this);
		var $imgSet=$this.find('.divBigImg');
		var $imgWin=$imgSet.find('.mainImg');
		var $page=$this.find('.divPage');
		var $pageCurrent=$page.find('.spanCurrent');
		var $pageTotal=$page.find('.spanTotal');
		var $thumSet=$this.find('.divSmallImg');
		var $thumMove=$thumSet.find('.ulSmallMove');
		var $thumList=$thumMove.find('li');
		var $thumLine=$this.find('.thumeBox');
		var $nextBtn=$this.find('.divclassrightarrow');
		var $prevBtn=$this.find('.divclassleftarrow');
		var $nextPageBtn=$this.find('.smallnextPageBtn');
		var $prevPageBtn=$this.find('.smallprevPageBtn');
		var objNum=$thumList.length;
		var currentObj=0;
		var fixObj=0;
		var currentPage=0;
		var totalPage=Math.floor(objNum/opt.thumMoveStep);
		var oldImg;

		init();

		function init(){
			setInit();
			setMouseEvent();
			changeImg();
		}

		function setInit(){
			
			$thumMove.append($thumLine.get())
		}

		
		function setMouseEvent(){
			$thumList.bind('click',function(e){
				e.preventDefault();
				currentObj=$(this).index();
				changeImg();
			});
			$nextBtn.bind('click',function(){
				currentObj++;
				changeImg();
				currentPage=Math.floor(currentObj/opt.thumMoveStep);
				moveThum();

			});
			$prevBtn.bind('click',function(){
				currentObj--;
				changeImg();
				currentPage=Math.floor(currentObj/opt.thumMoveStep);
				moveThum();
			});
			$nextPageBtn.bind('click',function(){
				currentPage++;
				moveThum();
			});
			$prevPageBtn.bind('click',function(){
				currentPage--;
				moveThum();
			});
		
		}
		
		
		function moveThum(){
			var pos=((opt.thumWidth+opt.thumGap)*opt.thumMoveStep)*currentPage
			$thumMove.animate({'left':-pos},opt.moveSpeed);
			
			setVisibleBtn();
		}

		
		function setVisibleBtn(){
			$prevPageBtn.show();
			$nextPageBtn.show();
			$prevBtn.show();
			$nextBtn.show();
			if(currentPage==0)$prevPageBtn.hide();
			if(currentPage==totalPage-1)$nextPageBtn.hide();
			if(currentObj==0)$prevBtn.hide();
			if(currentObj==objNum-1)$nextBtn.hide();
		}

		
		function changeImg(){
			if(oldImg!=null){
				
				$imgWin.css('background','url('+oldImg+') no-repeat');
			}
			
			var $thum=$thumList.eq(currentObj)
			var _src=oldImg=$thum.find('a').attr('href');
			$imgWin.find('img').hide().attr('src',_src).fadeIn(opt.fadeSpeed);
			oldImg=_src

			
			$thumLine.css({'left':$thum.position().left})

			
			$pageCurrent.text(currentObj+1);
			$pageTotal.text(objNum);
			
			setVisibleBtn();
		}
	})
}
})(jQuery)