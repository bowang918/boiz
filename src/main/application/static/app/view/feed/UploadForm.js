
Ext.define('App.view.feed.UploadForm',{
    extend: 'Ext.form.Panel',
    alias: 'widget.feedupload',


    // requires: [
    //     'App.view.feed.UploadFormController',
    //     'App.view.feed.UploadFormModel'
    // ],

    // controller: 'feed-uploadform',
    // viewModel: {
    //     type: 'feed-uploadform'
    // },

    fileUpload: true,
    layout: {
        type: 'vbox',
        align: 'stretch'
    },
    padding: '40px 20px 20px 20px',
    items: [ {
        xtype: 'filefield',
        itemId:'feedFile',
        maxWidth:600,
        // responsiveConfig: {
        //     'width < 768 && tall': {
        //         width:'40%'
        //     },
        //     'width >= 768': {
        //         width:'20%'
        //     }
        // },
        buttonOnly: false,
        allowBlank:false,
        // fieldLabel: 'File',
        name: 'feedFile',
        buttonText: '选择文件',
        listeners: {
            change: 'uploadFeed'
        }
    }],
    api: {
        submit: 'feedController.uploadFeed'
    }
});
