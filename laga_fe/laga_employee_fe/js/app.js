// postgres stuff goes here
const { Pool, Client } = require("pg");

const credentials = {
  user: "yddhfzehsbkgyt",
  host: "ec2-54-211-177-159.compute-1.amazonaws.com",
  database: "d7iooqqs5al1us",
  password: "3fde8d9ff4d0b5dc86b32742cd6ecb30f57407f15fd0f22f1f7c014b60970470",
  port: 5432,
};

async function poolDemo() {
  const pool = new Pool(credentials);
  const now = await pool.query("SELECT NOW()");
  await pool.end();

  return now;
}