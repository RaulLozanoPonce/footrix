const path = require("path");
const HtmlWebPackPlugin = require("html-webpack-plugin");
const CopyWebpackPlugin = require('copy-webpack-plugin');
const CircularDependencyPlugin = require('circular-dependency-plugin');

module.exports = {
	module: {
		rules: [
            {
                test: /node_modules\/ace-linters*/,
                use: { loader: 'babel-loader', options: { presets: ['@babel/preset-env'] } }
            },
            {
                test: /\.mjs$/,
                include: /node_modules/,
                type: "javascript/auto",
                loader: "babel-loader"
            },
			{
				test: /\.js$/,
				exclude: /node_modules\/(?!(alexandria-ui-elements)\/).*/,
				options: { rootMode: "upward", presets: ['@babel/preset-env'], cacheDirectory: true },
				loader: "babel-loader"
			},
			{
				test: /\.html$/,
				loader: "html-loader"
			},
			{
				test: /\.css$/,
				loader: 'style-loader!css-loader'
			}
		]
	},
	entry : {
		'matchesTemplate' : './gen/apps/MatchesTemplate.js',
		'classificationTemplate' : './gen/apps/ClassificationTemplate.js',
		'playerTraceTemplate' : './gen/apps/PlayerTraceTemplate.js',
		'appTemplate' : './gen/apps/AppTemplate.js'
	},
	output: {
		path: "/Users/raull/IdeaProjects/footrix/out/production/protrix-ui/www/protrix-ui",
		publicPath: '$basePath/protrix-ui/',
		filename: "[name].js"
	},
	resolve: {
		alias: {
			"app-elements": path.resolve(__dirname, '.'),
			"protrix-ui": path.resolve(__dirname, '.')
		}
	},
	plugins: [
		new CircularDependencyPlugin({
			failOnError: false,
			allowAsyncCycles: false,
			cwd: process.cwd(),
		}),
		new CopyWebpackPlugin([{
			from: 'res',
			to: './res'
		}]),
		new HtmlWebPackPlugin({
			hash: true,
			title: "Test UI",
			chunks: ['matchesTemplate'],
			template: "./src/matchesTemplate.html",
			filename: "./matchesTemplate.html"
		}),
		new HtmlWebPackPlugin({
			hash: true,
			title: "Test UI",
			chunks: ['classificationTemplate'],
			template: "./src/classificationTemplate.html",
			filename: "./classificationTemplate.html"
		}),
		new HtmlWebPackPlugin({
			hash: true,
			title: "Test UI",
			chunks: ['playerTraceTemplate'],
			template: "./src/playerTraceTemplate.html",
			filename: "./playerTraceTemplate.html"
		}),
		new HtmlWebPackPlugin({
			hash: true,
			title: "Test UI",
			chunks: ['appTemplate'],
			template: "./src/appTemplate.html",
			filename: "./appTemplate.html"
		})
	]
};