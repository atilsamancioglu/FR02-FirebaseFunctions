const functions = require("firebase-functions");

exports.commerceUploaded = functions.firestore.document("Commerce/Basket").onCreate((snap, context) => {

	const newData = snap.data();
	const price = newData.price;
	const quantity = newData.quantity;

	let total = price * quantity;

	return snap.ref.update({ total : total});

});