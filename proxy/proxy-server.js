const corsAnywhere = require('cors-anywhere');

const host = 'localhost';
const port = 8081;

// Create a CORS Anywhere server with custom options
corsAnywhere.createServer({
    originWhitelist: [], // Allow all origins
    requireHeaders: [], // No required headers
    removeHeaders: [], // No headers to remove
}).listen(port, host, () => {
    console.log(`CORS Anywhere running on ${host}:${port}`);
});
