/*
Copyright (c) 2003-2011, CKSource - Frederico Knabben. All rights reserved.
For licensing, see LICENSE.html or http://ckeditor.com/license
*/

CKEDITOR.editorConfig = function( config )
{
	// Define changes to default configuration here. For example:

	// config.language = 'fr';
	// config.uiColor = '#AADC6E';
	
	 config.language = 'zh-cn';//'fr';//语言 ，如'zh-cn'，'fr'
     config.width = '850px';//宽度  
     config.height = '500px';//高度  
     config.uiColor = '#AADC6E';//颜色  
     config.toolbar = 'Full';//有Full和Basic基本属性。也可以详细配置  
     config.skin = 'office2003';//如果不设置默认为kama,还有office2003和v2属性  
};
