show databases;

//friends of
MATCH (p:Person)-[:FRIEND_OF]->(friend:Person)
  WHERE p.id = 6
RETURN friend

//friends of friends who are not your friends
MATCH (p:Person)-[:FRIEND_OF]->()-[:FRIEND_OF]->(fof:Person)
  WHERE p.id = 5 AND NOT (p)-[:FRIEND_OF]->(fof) AND p <> fof
RETURN DISTINCT fof


//show all
MATCH (n)
RETURN n;

//Person id
MATCH (n:Person)
  WHERE n.id = 5
DETACH DELETE n


//Node id
MATCH (n)
  WHERE id(n) = 1
DETACH DELETE n

//USE neo4j
//MATCH (n:Person {id: "5"})
//RETURN n
