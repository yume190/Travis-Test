import httplib2

h = httplib2.Http(".cache")
h.add_credentials('user', 'pass')
r, content = h.request("https://api.github.com", "GET")

print r['status']
print r['content-type']

import pdb;pdb.set_trace()
