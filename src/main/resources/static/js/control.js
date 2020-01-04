$(function() {
	checkLogin = function() {
		$("#loginForm").submit();
	}
});

function genFile() {
	/*
	 * document.getElementById("email").value = "inner Address測試"; var zip = new
	 * JSZip(); zip.add("hello1.txt", document.getElementById("email").value);
	 * content = zip.generate(); location.href = "data:application/zip;base64," +
	 * content;
	 */

	var file = window.document.createElement('a');
	file.href = window.URL.createObjectURL(new Blob([ document
			.getElementById("email").value ], {
		type : 'text/plain;charset=utf-8'
	}));
	file.download = 'mapList.txt';
	file.click();
	window.URL.revokeObjectURL(file.href);
	
	// document.body.appendChild(a);
	// document.body.removeChild(a);
};