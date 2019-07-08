const csv=require('csvtojson')
const mysql = require('mysql');
const random = require('random');
const utf8 = require('utf8');

const con = mysql.createConnection({
  host: "localhost",
  user: "root",
  password: "root",
  database: "ecommerce"
});

async function run() {
  items = await csv().fromFile('items.csv');

  con.connect(function(err) {
    if (err) throw err;
    console.log("Connected!");
  
    let index = 0

    for (item of items) {
      let re = new RegExp('\"', 'g');
      title = item.title.replace(re, '///\\');

      if (title !== "None") {

        price = (item.price === 'None' | item.price === 'Liên h') ? -1 : item.price;
        amount = random.int(min = 1, max = 100);
        primaryImageURL = item.primary_image;
        imageURLs = item.item_images.replace(re, '///\\');
        categoryID = item.category_id;

        var sql = `INSERT INTO Item(Name, Price, Amount, PrimaryImageURL, ImageURLs, CategoryID) VALUES ("${title}", "${price}", "${amount}", "${primaryImageURL}", "${imageURLs}", "${categoryID}");`;

        //console.log(sql)

        con.query(sql, function (err, result) {
          if (err) throw err;
          console.log("1 record inserted");
        });
        index = index + 1;
        console.log(index);
      }
    }
  });
}

run();

