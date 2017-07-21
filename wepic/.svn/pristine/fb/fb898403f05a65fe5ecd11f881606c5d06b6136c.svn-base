/*!
 * strength.js
 * Original author: @aaronlumsden
 * Further changes, comments: @aaronlumsden
 * Licensed under the MIT license
 */
;(function ( $, window, document ) {

    var pluginName = "strength";

    function Plugin( element, options ) {
        this.element = element;
        this.$elem = $(this.element);
        this.options = $.extend( {}, options );
        this.init();
    }

    Plugin.prototype = {
        init: function() {
            var characters = 0;
            var capitalletters = 0;
            var loweletters = 0;
            var number = 0;
            var special = 0;

            var upperCase= new RegExp('[A-Z]');
            var lowerCase= new RegExp('[a-z]');
            var numbers = new RegExp('[0-9]');
            var specialchars = new RegExp('([!,%,&,@,#,$,^,*,?,_,~])');

            function GetPercentage(a, b) {
                    return ((b / a) * 100);
                }

                function check_strength(thisval,thisid){
                     if (thisval.length > 8) { characters = 1; } else { characters = 0; };
                    if (thisval.match(upperCase)) { capitalletters = 1} else { capitalletters = 0; };
                    if (thisval.match(lowerCase)) { loweletters = 1}  else { loweletters = 0; };
                    if (thisval.match(numbers)) { number = 1}  else { number = 0; };

                    var total = characters + capitalletters + loweletters + number + special;
                    var totalpercent = GetPercentage(7, total).toFixed(0);

                    get_total(total,thisid);
                }

            function get_total(total,thisid){
			  var allStrength = $("#allStrength").find("span");
			  $(allStrength).each(function() {
				  $(this).attr("class","password_gry");
			  });
                if(total == 0){
                	/*$(allStrength).each(function() {
                        $(this).attr("class","password_gry");
                    });*/
                }else if (total <= 1) {
					for(var i = 0 ; i < 1 ;i++){
						$(allStrength[i]).attr("class","password_red");
						}
					
                } else if (total == 2){
					for(var i = 0 ; i < 2 ;i++){
						$(allStrength[i]).attr("class","password_red");
						}
                } else if(total == 3){
					for(var i = 0 ; i < 3 ;i++){
						$(allStrength[i]).attr("class","password_red");
						}

                } else {
					$(allStrength).each(function() {
                        $(this).attr("class","password_red");
                    });
                } 
            }

             
            thisid = this.$elem.attr('id');
            this.$elem.bind('keyup keydown', function(event) {
                thisval = $('#'+thisid).val();
                check_strength(thisval,thisid);
                
            });

            
        },

    };



    $.fn[pluginName] = function ( options ) {
        return this.each(function () {
            if (!$.data(this, "plugin_" + pluginName)) {
                $.data(this, "plugin_" + pluginName, new Plugin( this, options ));
            }
        });
    };

})( jQuery, window, document );


