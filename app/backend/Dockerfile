FROM node:8.11.4

COPY ["package.json", "/usr/src/"]

WORKDIR /usr/src

RUN npm install -only=production

COPY [".", "/usr/src/"]

EXPOSE 3000

CMD ["node", "start"]
