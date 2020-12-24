db.auth('mongoadmin', 'mongoadmin')
db = db.getSiblingDB('data-fetcher')

db.createUser(
    {
        user: "mongoadmin",
        pwd: "mongoadmin",
        roles: [
            {
                role: "readWrite",
                db: "data-fetcher"
            }
        ]
    }
);
