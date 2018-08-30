FROM node:8.11.4

COPY ["package.json", "/usr/src/"]

WORKDIR /usr/src

#Just for PSL network
# RUN npm config set https-proxy http://[PSL_PROXY_USER]:[PSL_PROXY_PASSWORD]@10.10.10.12:8080

RUN npm install -only=production

COPY [".", "/usr/src/"]

EXPOSE 3001

CMD ["npm", "start"]
