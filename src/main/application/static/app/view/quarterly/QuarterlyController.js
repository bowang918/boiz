Ext.define('App.view.quarterly.QuarterlyController', {
	extend : 'Ext.app.ViewController',
	alias : 'controller.quarterly',
	requires : [ 'Ext.window.Toast' ],

	init : function(view) {
		// We provide the updater for the activeState config of our View.
		view.updateActiveState = this.updateActiveState.bind(this);
	},

	menuItemClick : function(button, menuitem) {
		var view = this.getView();
		view.setActiveState(menuitem.text);
	},

	updateActiveState : function(activeState) {
		var viewModel = this.getViewModel();

		viewModel.set('company', activeState);

		this.fireEvent('changeroute', this, 'quarterly/' + activeState);
	},

	uploadFeed : function(fileField, value) {
		var me = this, feedStore = me.getStore('feeds'), 
			form = fileField.up('form');
		if (form.isValid()) {
			console.log(value);
			form.submit({
				waitMsg : '文件上传中...',
				success : function(form, action) {
					feedStore && feedStore.reload();
					Ext.toast({
					     html: '文件上传成功！',
					     title: '恭喜你',
					     width: 240,
					     align: 'br'
					 });
				},
				failure : function(form, action) {
					Ext.toast({
					     html: '文件上传失败！',
					     title: '抱歉',
					     width: 240,
					     align: 'br'
					 });
				}
			});
		}
	}
});
